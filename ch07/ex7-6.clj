;; 기호

(if true :a :b)
; => :a


if
; => CompilerException: java.lang.RuntimeException: Unable to resolve symbol: if in this context, compiling:(NO_SOURCE_PATH:0:0)


(let [x 5]
  (+ x 3))
; => 8


(def x 15)
(+ x 3)
; => 18


(def x 15)
(let [x 5]
  (+ x 3))
; => 8


(let [x 5]
  (let [x 6]
(+ x 3)))
; => 9


(defn exclaim
  [exclamation]
  (str exclamation "!"))

(exclaim "Hadoken")
; => "Hadoken!"


(map inc [1 2 3])
; => (2 3 4)


(read-string "+")
; => +

(type (read-string "+"))
; => clojure.lang.Symbol

(list (read-string "+") 1 2)
; => (+ 1 2)


(eval (list (read-string "+") 1 2))
; => 3
