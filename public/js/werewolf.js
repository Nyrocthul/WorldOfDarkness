var app = angular.module("werewolf", []).controller("WerewolfCtrl", function ($scope){
  $scope.playerRolls = [new DieRoll("steve", 5,8,false), new DieRoll("bob", 32,8,true), new DieRoll("alice", 10,10,true)];
  $scope.dieRolls = {
    hits: 0,
    poolInitial: [],
    poolFromRote: [],
    hitsFromRote: 0,
    poolFromAgains: [],
    hitsFromAgains: 0
  };
  $scope.updateRoll = function(roll){
    $scope.dieRolls = roll.roll();
  }
  $scope.addDiceBag = function() {
    var charName = $scope.charName;
    var charSize = $scope.charSize;
    var charAgains = $scope.charAgains;
    var charRote = $scope.charRote;
    $scope.playerRolls.push(new DieRoll(charName, charSize, charAgains, charRote));
    console.log($scope.playerRolls);
  }
});

var DieRoll = function(name, size, agains, isRote) {
  this.name = name;
  this.size = size;
  this.agains = agains;
  this.isRote = isRote;
}

DieRoll.prototype.roll = function() {
  var results = worldOfDarknessRoll(this.size, this.isRote, this.agains);
  return results
}

function randoNumber(size) {
  var results = []
  for (i=0; i<size; i++){
    var num = 10*Math.random();
    num = Math.ceil(num);
    results.push(num);
  };
  return results;
}

function countDiceAbove(diceResults, agains) {
  var counter = 0;
  for (i=0; i<diceResults.length; i++){
    console.log(i);
    if (diceResults[i]>=agains){
      counter++;
    };
  };
  return counter;
}

function worldOfDarknessRoll(poolSize, isRote, agains) {

  var results = randoNumber(poolSize);
  var hits = countDiceAbove(results, 8);
  var misses = results.length - hits;
  var poolFromRote = [];
  var hitsFromRote = 0;
  if (isRote) {
    poolFromRote = randoNumber(misses);
    hitsFromRote = countDiceAbove(poolFromRote, 8);
  }
  var poolFromAgains = [];
  var numOfReRolls = countDiceAbove(results.concat(poolFromRote), agains);
  while (numOfReRolls > 0) {
    console.log("This is the numOfReRolls");
    console.log(numOfReRolls);
    var tempPool = randoNumber(numOfReRolls);
    poolFromAgains = poolFromAgains.concat(tempPool);
    numOfReRolls = countDiceAbove(tempPool, agains);
  }
  var hitsFromAgains = countDiceAbove(poolFromAgains, 8)
  hits += hitsFromAgains + hitsFromRote;
  return {
    hits,
    poolInitial: results,
    poolFromRote,
    hitsFromRote,
    poolFromAgains,
    hitsFromAgains
  }
}

//$(document).ready(function(){
//  $(".button").on("click", function(){
//    alert(JSON.stringify(this));
//  })
//})
