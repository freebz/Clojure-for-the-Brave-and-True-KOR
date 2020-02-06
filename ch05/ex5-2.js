// 순수한 함수는 부수 효과가 없다

var haplessObject = {
  emotion: "Carefree!"
};

var evilMutator = function(object){
  object.emotion = "So emo :'(";
}

evilMutator(haplessObject);
haplessObject.emotion;
// => "So emo :\'("
