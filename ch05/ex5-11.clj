;; 말뚝 옮기기

(defn pegged?
  "해당 위치에 말뚝이 있는지 확인하기"
  [board pos]
  (get-in board [pos :pegged]))

(defn remove-peg
  "주어진 위치의 말뚝 제거하기"
  [board pos]
  (assoc-in board [pos :pegged] false))

(defn place-peg
  "주어진 위치에 말뚝 넣기"
  [board pos]
  (assoc-in board [pos :pegged] true))

(defn move-peg
  "p1에서 p2로 말뚝 옮기기"
  [board p1 p2]
  (place-peg (remove-peg board p1) p2))


(defn valid-moves
  "키가 위치이고 뛰어넘은 위치가 값인 pos의 모든 유효한 값의 맵을 반환하기"
  [board pos]
  (into {}
        (filter (fn [[destination jumped]]
                  (and (not (pegged? board destination))
                       (pegged? board jumped)))
                (get-in board [pos :connections]))))


(def my-board (assoc-in (new-board 5) [4 :pegged] false))


(valid-moves my-board 1)  ; => {4 2}
(valid-moves my-board 6)  ; => {4 5}
(valid-moves my-board 11) ; => {4 7}
(valid-moves my-board 5)  ; => {}
(valid-moves my-board 8)  ; => {}


(defn valid-move?
  "p1에서 p2로 옮긴 것이 유효하면 건너뛴 위치를, 그렇지 않으면 nil을 반환하기"
  [board p1 p2]
  (get (valid-moves board p1) p2))

(valid-move? my-board 8 4) ; => nil
(valid-move? my-board 1 4) ; => 2


(defn make-move
  "말뚝을 p1에서 p2로 옮기고 건너뛴 말뚝 제거하기"
  [board p1 p2]
  (if-let [jumped (valid-move? board p1 p2)]
    (move-peg (remove-peg board jumped) p1 p2)))


(defn can-move?
  "말뚝이 박힌 위치 중 유효하게 움직일 수 있는 것이 있는가?"
  [board]
  (some (comp not-empty (partial valid-moves board))
        (map first (filter #(get (second %) :pegged) board))))
