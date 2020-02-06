;; 순수한 함수로 할 수 있는 멋진 것들

;; comp

((comp inc *) 2 3)
; => 7


(def character
  {:name "Smooches McCutes"
   :attributes {:intelligence 10
                :strength 4
                :dexterity 5}})
(def c-int (comp :intelligence :attributes))
(def c-str (comp :strength :attributes))
(def c-dex (comp :dexterity :attributes))

(c-int character)
; => 10

(c-str character)
; => 4

(c-dex character)
; => 5


(defn spell-slots
  [char]
  (int (inc (/ (c-int char) 2))))

(spell-slots character)
; => 6


(def spell-slots-comp (comp int inc #(/ % 2) c-int))


(defn two-comp
  [f g]
  (fn [& args]
    (f (apply g args))))
