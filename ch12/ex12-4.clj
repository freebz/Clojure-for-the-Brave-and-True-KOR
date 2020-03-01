;; 객체 만들고 바꾸기

(new String)
; => ""

(String.)
; => ""

(String. "To Davey Jones's Locker with ye hardies")
; => "To Davey Jones's Locker with ye hardies"


(java.util.Stack.)
; => []

(let [stack (java.util.Stack.)]
  (.push stack "Latest episode of Game of Thrones, ho!")
  stack)
; => ["Latest episode of Game of Thrones, ho!"]


(let [stack (java.util.Stack.)]
  (.push stack "Latest episode of Game of Thrones, ho!")
  (first stack))
; => "Latest episode of Game of Thrones, ho!"


(doto (java.util.Stack.)
  (.push "Latest episode of Game of Thrones, ho!")
  (.push "Whoops, I meant 'Land, ho!'"))
; => ["Latest episode of Game of Thrones, ho!" "Whoops, I meant 'Land, ho!'"]


(macroexpand-1
 '(doto (java.util.Stack.)
    (.push "Latest episode of Game of Thrones, ho!")
    (.push "Whoops, I meant 'Land, ho!'")))
; => (clojure.core/let
;     [G__2876 (java.util.Stack.)]
;     (.push G__2876 "Latest episode of Game of Thrones, ho!")
;     (.push G__2876 "Whoops, I meant 'Land, ho!'")
;     G__2876)
