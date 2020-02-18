;; 소스 코드 재정비 및 비인용 이음

(defn criticize-code
  [criticism code]
  `(println ~criticism (quote ~code)))

(defmacro code-critic
  [bad good]
  `(do ~(criticize-code "Cursed bacteria of Liberia, this is bad code:" bad)
       ~(criticize-code "Sweet sacred boa of Western and Eastern Samoa, this is good code:" good)))


(defmacro code-critic
  [bad good]
  `(do ~(map #(apply criticize-code %)
             [["Great squid of Madrid, this is bad code:" bad]
              ["Sweet gorilla of Manila, this is good code:" good]])))


(code-critic (1 + 1) (+ 1 1))
; => NullPointerException


(do
  ((clojure.core/println "criticism" '(1 + 1))
   (clojure.core/println "criticism" '(+ 1 1))))


(do
  (nil
   (clojure.core/println "criticism" '(+ 1 1))))


(do
  (nil nil))


`(+ ~(list 1 2 3))
; => (clojure.core/+ (1 2 3))


`(+ ~@(list 1 2 3))
; => (clojure.core/+ 1 2 3)


(defmacro code-critic
  [good bad]
  `(do ~@(map #(apply criticize-code %)
              [["Sweet lion of Zion, this is bad code:" bad]
               ["Great cow of Moscow, this is good code:" good]])))

(code-critic (1 + 1) (+ 1 1))
             ; => Sweet lion of Zion, this is bad code: (+ 1 1)
             ; => Great cow of Moscow, this is good code: (1 + 1)
