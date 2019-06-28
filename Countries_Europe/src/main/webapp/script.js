

document.getElementById("svg2").addEventListener("click", function(e){
    // get the data from the proxy server 
    fetch('http://localhost:8084/proxy/Api/ProxyApi/countries/'+ e.target.id, {
       method: "GET",
        headers: {
            "Content-Type": "application/json",
            "Accept": "application/json"
        }
   })
  .then(function(response) {
    return response.json();
  })
  .then(function(myJson) {
     
      var html = "";
    
      // loop over the data and bulid up the html       
      for(var i = 0; i <myJson.length; i++){
          html += "<p>" + "Country " + myJson[i].name + "</p>";
          html += "<p>" + "population " + myJson[i].population + "</p>";
          html += "<p>" + "Borders " + myJson[i].borders + "</p>";
      }
     document.getElementById("showInfo").innerHTML = html;
  });
  //fill the target id whit red color
 document.getElementById(e.target.id).style.fill = "red";



});










