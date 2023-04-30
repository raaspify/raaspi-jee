package com.rcomputer.genapp.action;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import java.util.logging.Logger;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.SecureRandom;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import javax.annotation.PostConstruct;


import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;


/**
 * Component used to hold a user password during registration.
 * 
 * @author thelabdude
 */
@Named("passwordSupport")
//@Scope(ScopeType.EVENT)
@RequestScoped
public class PasswordSupport {
   private static byte[] saltToByte=null;
   private static int saltLength = 128; 
   private static String hex = "0123456789ABCDEF";

	public static final String tempPassword() {
		java.util.Random rand = new java.util.Random();
		int[] aNums = new int[8];
		for (int n = 0; n < aNums.length; n++)
			aNums[n] = rand.nextInt(9) + 1;
		char[] ach1 = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
				'j'};
		char[] ach2 = new char[]{'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T',
				'U'};
		char[] ach3 = new char[]{'v', 'w', 'x', 'y', 'z', 'V', 'W', 'X', 'Y',
				'Z'};
		char[] ach4 = new char[]{'k', '$', 'm', 'n', 'p', 'q', 'r', 's', 't',
				'u'};
		char[] ach5 = new char[]{'$', '%', '!', '#', '$', '%', '!', '#', '$',
				'%'};
          // since passwords expire and users are forced to change make them simpler ie 4 ch long and 3 lower case and one numeric 
           /*
		return (ach4[aNums[7]] + String.valueOf(aNums[2]) + ach1[aNums[3]]
				+ String.valueOf(aNums[0]) + ach3[aNums[5]] + ach2[aNums[4]]
				+ ach4[aNums[6]] + ach5[aNums[1]]);
           */
		return (ach4[aNums[7]] + String.valueOf(aNums[2]) + ach1[aNums[3]]
				 + ach1[aNums[5]]);
	}
     // note in db currentpassword is actually hashed password and passwordhash actually holds salttobyte value
     // in authentication salttobyte is read from db and using that value the plaintext password entered is hashed and compared against 
     // hashed value stored as currentpassword.
	public static final String hash(String plainTextPassword) {
         try{
           char[] passToChar=plainTextPassword.toCharArray();
           //setSaltLength(128);
           if (getHashNoon()== null){ 
            saltToByte =  generateRandomSalt();
           }
           setHashNoon(saltToByte);
		return createPasswordKey(passToChar, saltToByte, 1000);
         }catch (Exception e) {
			e.printStackTrace();
          ///return null;
             return "manager";
	    }
	}
	public static final String hash(String plainTextPassword,byte[] saltToBytedb) {
         try{
           char[] passToChar=plainTextPassword.toCharArray();
           //setSaltLength(128);
           //setHashNoon(saltToByte);
		return createPasswordKey(passToChar, saltToBytedb, 1000);
         }catch (Exception e) {
			e.printStackTrace();
          return null;
	    }
	}
	public static byte[] getHashNoon() {
		return saltToByte;
	}

	public static void setHashNoon(byte[] value) {
		saltToByte = value;
	}


	private String password = null;

	private String confirm = null;
	private String confirm2 = null;


	public String getPassword() {
		return password;
	}

	public void setPassword(String value) {
		///this.password = org.jboss.seam.util.Strings.nullIfEmpty(value);
		this.password = null;
	}

	public String getPasswordConfirm() {
		return confirm;
	}

	public void setPasswordConfirm(String confirm) {
		this.confirm = confirm;
	}

	public boolean isConfirmed() {
		return (confirm != null && confirm.equals(password));
	}

	public boolean checkConfirmed(FacesMessage message,
			String controlId) {
		boolean isConfirmed = isConfirmed();
		if (!isConfirmed) {
			//statusMessages.addToControlFromResourceBundle(controlId, ERROR,
			//		"admin password_not_confirmed");
		}
		return isConfirmed;
	}

	public String getPasswordConfirm2() {
		return confirm2;
	}

	public void setPasswordConfirm2(String confirm2) {
		this.confirm2 = confirm2;
	}
	public boolean isConfirmed2() {
		return (confirm2 != null && confirm2.equals(password));
	}

	public boolean checkConfirmed2(FacesMessage message,
			String controlId) {
		boolean isConfirmed2 = isConfirmed2();
		if (!isConfirmed2) {
			//statusMessages.addToControlFromResourceBundle(controlId, ERROR,
			//		"user password_not_confirmed");
		}
		return isConfirmed2;
	}

	@Override
	public String toString() {
		return new StringBuilder("PasswordSupport[").append("password=")
				.append(password).append(", confirm=").append(confirm).append(
						"]").toString();
	}
/*
   public int getSaltLength()
   {
      return saltLength;
   }
   
   public static void setSaltLength(int saltLength)
   {
      this.saltLength = saltLength;
   }
*/
   public static byte[] generateRandomSalt()
   {      
      byte[] salt = new byte[saltLength];
      new SecureRandom().nextBytes(salt);
      return salt;      
   }
   /**
    * 
    */
   public static String createPasswordKey(char[] password, byte[] salt, int iterations) 
      throws GeneralSecurityException 
   {
//Security.getProviders() PBEWITHSHA1ANDDESEDE PBEWITHSHA1ANDRC2_40
      String hashAlgorithm="";
      if (hashAlgorithm != null && !hashAlgorithm.isEmpty()){
         PBEKeySpec passwordKeySpec = new PBEKeySpec(password, salt, iterations, 160);
         
         SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(hashAlgorithm);
         SecretKey passwordKey = secretKeyFactory.generateSecret(passwordKeySpec);
         passwordKeySpec.clearPassword();
         return bin2hex(passwordKey.getEncoded());
      }else {
         PBKDF2Parameters params = new PBKDF2Parameters("HmacSHA1", "ISO-8859-1", salt, iterations);
         PBKDF2 pbkdf2 = new PBKDF2Engine(params);
         return BinTools.bin2hex(pbkdf2.deriveKey(new String(password)));
      }
   }

   public static String bin2hex(final byte[] b)
   {
      if (b == null)
      {
         return "";
      }
      StringBuffer sb = new StringBuffer(2 * b.length);
      for (int i = 0; i < b.length; i++)
      {
         int v = (256 + b[i]) % 256;
         sb.append(hex.charAt((v / 16) & 15));
         sb.append(hex.charAt((v % 16) & 15));
      }
      return sb.toString();
   }
   


        
 
}
