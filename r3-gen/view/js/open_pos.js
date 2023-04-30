//used by Android and invoked by button onclick in checkoutPOS.chtml
// The URL where the Point of Sale app will send the transaction results.
//in IOS/ipad checkoutPOS has embedded js to use window.location ..create?data=

//alert ('open_pos.js started'+window.location);
//alert (window.location);
//alert(document.readyState);

var callbackUrl = "https://"+window.location.hostname+"/checkoutPOS.wflow";
//alert('callbackUrI'+callbackUrl);
// Your application ID
var applicationId = "";

// The total and currency code should come from your transaction flow.
// For now, we are hardcoding them if test, 100 means 1 $ change raaspi logic re currency, for now USD
//in jsf id changes with namespace, use hidden html element
var transactionTotal = "";
var currencyCode = "";
var state ="";
var note ="";

// The version of the Point of Sale SDK that you are using. no square fees if cash/other
var sdkVersion = "v2.0";



function openURL(){
 // Configure the allowable tender types, state should be url not just owner2, cant figure out exact url here or later
    //alert('after call'+document.readyState); turn off alert in prod affects launching app
 applicationId = document.getElementById("applicationIdJ").value;
 currencyCode = document.getElementById("currencyCodeJ").value;
 state ="r3po"+document.getElementById("cartOrderJ").value+"r3o2"+document.getElementById("cartO2J").value+"r3bk"+document.getElementById("stateJ").value;

 transactionTotal = document.getElementById("CartnpTotalValueJ").value*100;
 note = document.getElementById("noteJ").value;
 var tenderTypes = "com.squareup.pos.TENDER_CARD";

  var posUrl ="intent:#Intent;" +"action=com.squareup.pos.action.CHARGE;" +"package=com.squareup;" +"S.com.squareup.pos.WEB_CALLBACK_URI=" + callbackUrl + ";" +"S.com.squareup.pos.CLIENT_ID=" + applicationId + ";" +"S.com.squareup.pos.API_VERSION=" + sdkVersion + ";" +"i.com.squareup.pos.TOTAL_AMOUNT=" + transactionTotal + ";" +"S.com.squareup.pos.CURRENCY_CODE=" + currencyCode + ";" +"S.com.squareup.pos.REQUEST_METADATA=" + state + ";" +"S.com.squareup.pos.NOTE=" + note + ";"+"S.com.squareup.pos.TENDER_TYPES=" + tenderTypes + ";" +"end";
  //alert ('amount: ' + transactionTotal/100 );
  //alert('pass'+posUrl);
  //opens square pos app in a new Tab
  window.open(posUrl);

}


