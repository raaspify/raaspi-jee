package com.rcomputer.genapp.action;
import java.io.UnsupportedEncodingException;

/**
 * Copied from Matthias Gartner's PKCS#5 implementation - see
 * http://rtner.de/software/PBKDF2.html
 * 
 * <p>
 * Request for Comments: 2898 PKCS #5: Password-Based Cryptography Specification
 * <p>
 * Version 2.0
 * 
 * <p>
 * PBKDF2 (P, S, c, dkLen)
 * 
 * <p>
 * Options:
 * <ul>
 * <li>PRF underlying pseudorandom function (hLen denotes the length in octets
 * of the pseudorandom function output). PRF is pluggable.</li>
 * </ul>
 * 
 * <p>
 * Input:
 * <ul>
 * <li>P password, an octet string</li>
 * <li>S salt, an octet string</li>
 * <li>c iteration count, a positive integer</li>
 * <li>dkLen intended length in octets of the derived key, a positive integer,
 * at most (2^32 - 1) * hLen</li>
 * </ul>
 * 
 * <p>
 * Output:
 * <ul>
 * <li>DK derived key, a dkLen-octet string</li>
 * </ul>
 * 
 * <hr />
 * <p>
 * A free Java implementation of Password Based Key Derivation Function 2 as
 * defined by RFC 2898. Copyright (c) 2007 Matthias G&auml;rtner
 * </p>
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * </p>
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 * </p>
 * <p>
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA
 * </p>
 * <p>
 * For Details, see <a
 * href="https://www.gnu.org/licenses/old-licenses/lgpl-2.1.html"
 * >https://www.gnu.org/licenses/old-licenses/lgpl-2.1.html</a>.
 * </p>
 * 
 * @see <a href="https://tools.ietf.org/html/rfc2898">RFC 2898</a>
 * @author Matthias G&auml;rtner
 * @version 1.0
 */
public class PBKDF2Engine implements PBKDF2
{
   protected PBKDF2Parameters parameters;
   
   protected PRF prf;
   
   /**
    * Constructor for PBKDF2 implementation object. PBKDF2 parameters must be
    * passed later.
    */
   public PBKDF2Engine()
   {
      this.parameters = null;
      prf = null;
   }
   
   /**
    * Constructor for PBKDF2 implementation object. PBKDF2 parameters are passed
    * so that this implementation knows iteration count, method to use and
    * String encoding.
    * 
    * @param parameters
    *           Data holder for iteration count, method to use et cetera.
    */
   public PBKDF2Engine(PBKDF2Parameters parameters)
   {
      this.parameters = parameters;
      prf = null;
   }
   
   /**
    * Constructor for PBKDF2 implementation object. PBKDF2 parameters are passed
    * so that this implementation knows iteration count, method to use and
    * String encoding.
    * 
    * @param parameters
    *           Data holder for iteration count, method to use et cetera.
    * @param prf
    *           Supply customer Pseudo Random Function.
    */
   public PBKDF2Engine(PBKDF2Parameters parameters, PRF prf)
   {
      this.parameters = parameters;
      this.prf = prf;
   }
   
   public byte[] deriveKey(String inputPassword)
   {
      return deriveKey(inputPassword, 0);
   }
   
   public byte[] deriveKey(String inputPassword, int dkLen)
   {
      byte[] r = null;
      byte P[] = null;
      String charset = parameters.getHashCharset();
      if (inputPassword == null)
      {
         inputPassword = "";
      }
      try
      {
         if (charset == null)
         {
            P = inputPassword.getBytes();
         }
         else
         {
            P = inputPassword.getBytes(charset);
         }
      }
      catch (UnsupportedEncodingException e)
      {
         throw new RuntimeException(e);
      }
      assertPRF(P);
      if (dkLen == 0)
      {
         dkLen = prf.getHLen();
      }
      r = PBKDF2(prf, parameters.getSalt(), parameters.getIterationCount(), dkLen);
      return r;
   }
   
   public boolean verifyKey(String inputPassword)
   {
      byte[] referenceKey = getParameters().getDerivedKey();
      if (referenceKey == null || referenceKey.length == 0)
      {
         return false;
      }
      byte[] inputKey = deriveKey(inputPassword, referenceKey.length);
      
      if (inputKey == null || inputKey.length != referenceKey.length)
      {
         return false;
      }
      for (int i = 0; i < inputKey.length; i++)
      {
         if (inputKey[i] != referenceKey[i])
         {
            return false;
         }
      }
      return true;
   }
   
   /**
    * Factory method. Default implementation is (H)MAC-based. To be overridden
    * in derived classes.
    * 
    * @param P
    *           User-supplied candidate password as array of bytes.
    */
   protected void assertPRF(byte[] P)
   {
      if (prf == null)
      {
         prf = new MacBasedPRF(parameters.getHashAlgorithm());
      }
      prf.init(P);
   }
   
   public PRF getPseudoRandomFunction()
   {
      return prf;
   }
   
   /**
    * Core Password Based Key Derivation Function 2.
    * 
    * @see <a href="https://tools.ietf.org/html/rfc2898">RFC 2898 5.2</a>
    * @param prf
    *           Pseudo Random Function (i.e. HmacSHA1)
    * @param S
    *           Salt as array of bytes. <code>null</code> means no salt.
    * @param c
    *           Iteration count (see RFC 2898 4.2)
    * @param dkLen
    *           desired length of derived key.
    * @return internal byte array
    */
   protected byte[] PBKDF2(PRF prf, byte[] S, int c, int dkLen)
   {
      if (S == null)
      {
         S = new byte[0];
      }
      int hLen = prf.getHLen();
      int l = ceil(dkLen, hLen);
      int r = dkLen - (l - 1) * hLen;
      byte T[] = new byte[l * hLen];
      int ti_offset = 0;
      for (int i = 1; i <= l; i++)
      {
         _F(T, ti_offset, prf, S, c, i);
         ti_offset += hLen;
      }
      if (r < hLen)
      {
         // Incomplete last block
         byte DK[] = new byte[dkLen];
         System.arraycopy(T, 0, DK, 0, dkLen);
         return DK;
      }
      return T;
   }
   
   /**
    * Integer division with ceiling function.
    * 
    * @see <a href="https://tools.ietf.org/html/rfc2898">RFC 2898 5.2 Step 2.</a>
    * @param a
    * @param b
    * @return ceil(a/b)
    */
   protected int ceil(int a, int b)
   {
      int m = 0;
      if (a % b > 0)
      {
         m = 1;
      }
      return a / b + m;
   }
   
   /**
    * Function F.
    * 
    * @see <a href="https://tools.ietf.org/html/rfc2898">RFC 2898 5.2 Step 3.</a>
    * @param dest
    *           Destination byte buffer
    * @param offset
    *           Offset into destination byte buffer
    * @param prf
    *           Pseudo Random Function
    * @param S
    *           Salt as array of bytes
    * @param c
    *           Iteration count
    * @param blockIndex
    */
   protected void _F(byte[] dest, int offset, PRF prf, byte[] S, int c, int blockIndex)
   {
      int hLen = prf.getHLen();
      byte U_r[] = new byte[hLen];
      
      // U0 = S || INT (i);
      byte U_i[] = new byte[S.length + 4];
      System.arraycopy(S, 0, U_i, 0, S.length);
      INT(U_i, S.length, blockIndex);
      
      for (int i = 0; i < c; i++)
      {
         U_i = prf.doFinal(U_i);
         xor(U_r, U_i);
      }
      System.arraycopy(U_r, 0, dest, offset, hLen);
   }
   
   /**
    * Block-Xor. Xor source bytes into destination byte buffer. Destination
    * buffer must be same length or less than source buffer.
    * 
    * @param dest
    * @param src
    */
   protected void xor(byte[] dest, byte[] src)
   {
      for (int i = 0; i < dest.length; i++)
      {
         dest[i] ^= src[i];
      }
   }
   
   /**
    * Four-octet encoding of the integer i, most significant octet first.
    * 
    * @see <a href="https://tools.ietf.org/html/rfc2898">RFC 2898 5.2 Step 3.</a>
    * @param dest
    * @param offset
    * @param i
    */
   protected void INT(byte[] dest, int offset, int i)
   {
      dest[offset + 0] = (byte) (i / (256 * 256 * 256));
      dest[offset + 1] = (byte) (i / (256 * 256));
      dest[offset + 2] = (byte) (i / (256));
      dest[offset + 3] = (byte) (i);
   }
   
   public PBKDF2Parameters getParameters()
   {
      return parameters;
   }
   
   public void setParameters(PBKDF2Parameters parameters)
   {
      this.parameters = parameters;
   }
   
   public void setPseudoRandomFunction(PRF prf)
   {
      this.prf = prf;
   }
}
