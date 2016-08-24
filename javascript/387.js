/**
 * @param {string} s
 * @return {number}
 */
var firstUniqChar = function(s) {
  var index = 0;
  var list = [];
  if (s.length == 1) {
    return 0;
  }
  while (index < s.length) {
    var current = s.charAt(index);
    if (list.indexOf(current) == -1) {
      if (s.indexOf(current, index + 1) == -1) {
        return index;
      } else {
        list.push(current);
        index = index + 1;
      }
    } else {
      index = index + 1;
    }

  }
  if (index >= s.length) {
    return -1;
  }
};
console.log(firstUniqChar("dddccdbba"));
