//Write a function that takes a string as input and returns the string reversed.
//
//
//Example:
//Given s = "hello", return "olleh".
//

/**
 * @param {string} s
 * @return {string}
 */
var reverseString = function(s) {
    var res = "";
    var length = s.length;
    for(var i = length - 1; i >= 0; i--){
        res += s.charAt(i);
    }
    return res;
};