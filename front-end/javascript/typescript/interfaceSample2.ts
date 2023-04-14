interface ServerResponse{
    name:string;
    pageNumber:number;
    user:string[]

}

function printServerResponse(response:ServerResponse){
    console.log(response.name,response.pageNumber)
    response.user.forEach((v)=>console.log(v))
}

let user = ["ads","adsf","asd","adsf"]; 

let responseData:ServerResponse = {
    name: "sample name",
    pageNumber: 1,
    user: ["test","test1","test2","test3"]
}

printServerResponse(responseData);