//If successful, Square Point of Sale returns the following parameters. for Android
// similar js file exists for ios called callbacki.js
const clientTransactionId = "com.squareup.pos.CLIENT_TRANSACTION_ID";
const transactionId = "com.squareup.pos.SERVER_TRANSACTION_ID";

//If there's an error, Square Point of Sale returns the following parameters.
const errorField = "com.squareup.pos.ERROR_CODE";

//Get the URL parameters and puts them in an array
function getUrlParams(URL) {
    var vars = {};
    var parts = URL.replace(/[?&]+([^=&]+)=([^&]*)/gi,
    function(m,key,value) {
      vars[key] = value;

    });
    return vars;
  }
//get the data URL and encode in JSON
function getTransactionInfo(URL) {
    var data = decodeURI(URL.searchParams.get("data"));

    console.log("data: " + data);
    var transactionInfo = JSON.parse(data);
    return transactionInfo;
  }

  //below common for android/ios 
  // Makes a result string for success situation
function handleSuccess(transactionInfo){
  var resultString ="";

  if (clientTransactionId in transactionInfo) {
    resultString += "Client Transaction ID: " + transactionInfo[clientTransactionId] + "<br>";
  }
  if (transactionId in transactionInfo) {
    resultString += "Transaction ID: " + transactionInfo[transactionId] + "<br>";
  }
   else {
    resultString += "Transaction ID: NO CARD USED<br>";
  }
  return resultString;
}


// Makes an error string for error situation
function handleError(transactionInfo){
  var resultString ="";

  if (errorField in transactionInfo) {
    resultString += "Client Transaction ID: " + transactionInfo[clientTransactionId] + "<br>";
  }
  if (transactionId in transactionInfo) {
    resultString += "Transaction ID: " + transactionInfo[transactionId] + "<br>";
  }
   else {
    resultString += "Transaction ID: PROCESSED OFFLINE OR NO CARD USED<br>";
  }
  return resultString;
}

// Determines whether error or success based on urlParams, then prints the string
function printResponse() {
  var responseUrl = window.location.href;
  var transactionInfo = getTransactionInfo(responseUrl);
  var resultString = "";

  if (errorField in transactionInfo) {
    resultString = handleError(transactionInfo);
  } else {
    resultString = handleSuccess(transactionInfo);
  }

  document.getElementById('url').innerHTML = resultString;
}

