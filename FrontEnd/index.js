// post employee
var formE1 = document.getElementById('form');
     formE1?.addEventListener('submit',event =>{
        event.preventDefault();

        const formData = new FormData(formE1);
        const data = Object.fromEntries(formData)

        fetch(`http://localhost:8080/api/employee`,{
            method: 'POST',
            headers:{
                'content-Type':'application/json; charset=UTF-8'
            },
            body:JSON.stringify(data)
        })
       .then(function(response){
            return response.json()
        })
      .then(function(data){
          console.log(data)
       })
       if(formE1==null){
        alert("Not created");
     }else{
        alert("Employee Created successfully");
     }
     });
     

     

 //Get All employee
document.addEventListener(
    'DOMContentLoaded', () =>  {
       console.log('page loaded')
    })
let button = document.getElementById('button1')
button.onclick =() =>{
    console.log("button pressed")
    const api_url = `http://localhost:8080/api/employee`
     async function getemployee(){
                 const responce = await fetch(api_url);
                 const data = await responce.json();
                 const{ fname, lname, tel, address, city, state, zip, email} =data;
                 const continer=document.getElementById("card-continer");
                 for (var i = 0; i < data.length; i++) {
                     const content=`<div class="col-sm-4 mt-5" >
                     <div class="card">
                      <div class="card-body">
                         <img class="card-img-top" src="logo.jpeg" alt="Card image cap">
                          <p class="card-text1"> ${data[i].fname +" "+ data[i].lname}</p>
                          <p class="card-text1">Employee Id:${data[i].id}</p></br>
                          <p class="card-text ">${data[i].tel}</p>
                          <p class="card-text">${data[i].address} </p>
                          <p class="card-text">${data[i].city+","+data[i].state}</p>
                          <p class="card-text">${data[i].zip}</p>
                          <p class="card-text1"><a href="mailto:someone@example.com">${data[i].email}</a></p>
                      </div>
                    </div>
               </div>`
  continer.innerHTML+=content
  }
}
getemployee();
}

//get employee by id
let button2 = document.getElementById('button3')

button2.onclick =() =>{
    console.log("button pressed")
    //var x = document.getElementById("id").innerHTML;
   var x = parseInt(document.getElementById('id').value);
    console.log(x)
    const api_url = `http://localhost:8080/api/employee/${x}`
    async function getemployee1(){
                 const responce = await fetch(api_url);
                 const data = await responce.json();
                 console.log(responce,data)
                 
                 const continer=document.getElementById("card-continer2");
 
                     const content=`<div class="col-sm-4 mt-5" >
                     <div class="card">
                      <div class="card-body">
                      <img class="card-img-top" src="logo.jpeg" alt="Card image cap">
                      <p class="card-text1"> ${data.fname +""+ data.lname}</p>
                      <p class="card-text1">Employee Id:${data.id}</p></br>
                          <p class="card-text ">${data.tel}</p>
                          <p class="card-text">${data.address} </p>
                          <p class="card-text">${data.city+","+data.state}</p>
                          <p class="card-text">${data.zip}</p>
                          <p class="card-text1"><a href="mailto:someone@example.com">${data.email}</a></p>
                      </div>
                    </div>
               </div>`
  continer.innerHTML+=content
 
}
getemployee1();
}










