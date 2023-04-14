function printServerResponse(response) {
    console.log(response.name, response.pageNumber);
    response.user.forEach(function (v) { return console.log(v); });
}
var user = ["ads", "adsf", "asd", "adsf"];
var responseData = {
    name: "sample name",
    pageNumber: 1,
    user: ["test", "test1", "test2", "test3"]
};
printServerResponse(responseData);
