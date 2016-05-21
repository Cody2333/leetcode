/**
 * @param {string} s
 * @param {string[]} words
 * @return {number[]}
 */
 
function matchWords(str , words) {
    var q;
    for (q=0; q<words.length; q++) {
        if (str == words[q]) {
            return true;
        }
    }
    return false;
}

var findSubstring = function(s, words) {
    var length = words[0].length;
    var i=0;
    var pointer = 0;
    var j=0;
    var matchcount = 0;
    var index;
    var result=[];
    var x;
    while(i < s.length) {
        x=i;
        while (matchWords(s.slice(x,x+length),words)) {
            matchcount++;
            if (matchcount == words.length){
                result.push(i); 
                matchcount = 0;
                break;
            } else {
                x=x+length;
            }
        }
        i++;
    }
    
    return result;
};
