var SampleName = /** @class */ (function () {
    function SampleName() {
    }
    SampleName.prototype.message = function () {
        return "sample messaeg";
    };
    return SampleName;
}());
var sample = new SampleName();
console.log(sample.message());
