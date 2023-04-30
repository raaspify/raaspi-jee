/**
 *This js does function called calculate used by usageby
 *one parameter which passes the formulae expression
 *the naming of actual and formulae column and property name via reveng.xml has strict convention so that /g ie global replace can work
*/
function calculate(formulae){
    "use strict";
    try{
     if(/[^0-9()*+\/ .-]+/.test(formulae.value)) throw Error('bad input for calculation...');
        var ans= eval(formulae.value).toFixed(2);
     }
    catch(er){
        alert(er.message);
    }
    var otherid=formulae.name.replace(/5xxzc/g,'4xxza').replace(/rbx/g,'rbv').replace(/formulae/g,'');
    document.getElementById( otherid).value = ans;
    
}

