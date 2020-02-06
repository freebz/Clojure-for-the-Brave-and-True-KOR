;; 보드 만들기

(defn tri*
  "삼각수의 느긋한 배열 만들기"
  ([] (tri* 0 1))
  ([sum n]
     (let [new-sum (+ sum n)]
       (cons new-sum (lazy-seq (tri* new-sum (inc n)))))))


(def tri (tri*))


(take 5 tri)
; => (1 3 6 10 15)


(defn triangular?
  "주어진 숫자가 1, 3, 6, 10, 15 등과 같은 삼각 수인지 판정하기"
  [n]
  (= n (last (take-while #(>= n %) tri))))
(triangular? 5)
; => false

(triangular? 6)
; => true


(defn row-tri
  "n번 째 줄 끝의 삼각수 찾기"
  [n]
  (last (take n tri)))
(row-tri 1)
; => 1

(row-tri 2)
; => 3

(row-tri 3)
; => 6


(defn row-num
  "보드 위치가 속하는 가로 줄 번호 찾기: 예. 위치 1 -> 1번째 가로줄,
   위치 2 및 3 -> 2번째 가로줄 등"
  [pos]
  (inc (count (take-while #(> pos %) tri))))
(row-num 1)
; => 1

(row-num 5)
; => 3


(defn connect
  "두 위치 간 서로 연결맺기"
  [board max-pos pos neighbor destination]
  (if (<= destination max-pos)
    (reduce (fn [new-board [p1 p2]]
              (assoc-in new-board [p1 :connections p2] neighbor))
            board
            [[pos destination] [destination pos]])
    board))

(connect {} 15 1 2 4)
; => {1 {:connections {4 2}}
;     4 {:connections {1 2}}}


(assoc-in {} [:cookie :monster :vocals] "Finntroll")
; => {:cookie {:monster {:vocals "Finntroll"}}}

(get-in {:cookie {:monster {:vocals "Finntroll"}}} [:cookie :monster])
; => {:vocals "Finntroll"}

(assoc-in {} [1 :connections 4] 2)
; => {1 {:connections {4 2}}}


(defn connect-right
  [board max-pos pos]
  (let [neighbor (inc pos)
        destination (inc neighbor)]
    (if-not (or (triangular? neighbor) (triangular? pos))
      (connect board max-pos pos neighbor destination)
      board)))

(defn connect-down-left
  [board max-pos pos]
  (let [row (row-num pos)
        neighbor (+ row pos)
        destination (+ 1 row neighbor)]
    (connect board max-pos pos neighbor destination)))

(defn connect-down-right
  [board max-pos pos]
  (let [row (row-num pos)
        neighbor (+ 1 row pos)
        destination(+ 2 row neighbor)]
    (connect board max-pos pos neighbor destination)))


(connect-down-left {} 15 1)
; => {1 {:connections {4 2}}
;     4 {:connections {1 2}}}

(connect-down-right {} 15 3)
; => {3  {:connections {10 6}}
;     10 {:connections {3 6}}}


(defn add-pos
  "위치에 말뚝을 옮기고 연결짓기"
  [board max-pos pos]
  (let [pegged-board (assoc-in board [pos :pegged] true)]
    (reduce (fn [new-board connection-creation-fn]
              (connection-creation-fn new-board max-pos pos))
            pegged-board
            [connect-right connect-down-left connect-down-right])))

(add-pos {} 15 1)
; => {1 {:connections {4 2, 6 3}, :pegged true}
;     4 {:connections {1 2}}
;     6 {:connections {1 3}}}


(defn clean
  [text]
  (reduce (fn [string string-fn] (string-fn string))
          text
          [s/trim #(s/replace % #"lol" "LOL")]))


(defn new-board
  "주어진 숫자 만큼의 가로 줄이 있는 보드 만들기"
  [rows]
  (let [initial-board {:rows rows}
        max-pos (row-tri rows)]
    (reduce (fn [board pos] (add-pos board max-pos pos))
            initial-board
            (range 1 (inc max-pos)))))
