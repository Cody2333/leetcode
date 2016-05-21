/**
 * @param {number[][]} matrix
 * @return {number[]}
 */
var spiralOrder = function(matrix) {
  var result = [];
  var initX = 0;
  var initY = 0;
  if (matrix.length == 0) {
    return [];
  }
  var endX = matrix.length - 1;
  var endY = matrix[0].length - 1;

  var i;
  var j;
  while (initX < endX && initY < endY) {
    for (i = initY; i < endY; i++) {
      result.push(matrix[initX][i]);
    }
    for (j = initX; j < endX; j++) {
      result.push(matrix[j][endY]);
    }
    for (i = endY; i > initY; i--) {
      result.push(matrix[endX][i]);
    }
    for (j = endX; j > initX; j--) {
      result.push(matrix[j][initY]);
    }
    initX = initX + 1;
    initY = initY + 1;
    endX = endX - 1;
    endY = endY - 1;
  }
  if (initX == endX && initY == endY) {
    result.push(matrix[initX][initY]);
  } else if (initX == endX) {
    //one colomn
    for (var q = initY; q < endY + 1; q++) {
      result.push(matrix[initX][q]);
    }
  } else if (initY == endY) {
    //one raw
    for (var p = initX; p < endX + 1; p++) {
      result.push(matrix[p][initY]);
    }
  }
  return result;
};
