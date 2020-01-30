;; 목록, 벡터, 집합, 맵을 배열로 다루기

(defn titleize
  [topic]
  (str topic " for the Brave and True"))

(map titleize ["Hamsters" "Ragnarok"])
; => ("Hamsters for the Brave and True" "Ragnarok for the Brave and True")

(map titleize '("Empathy" "Decorating"))
; => ("Empathy for the Brave and True" "Decorating for the Brave and True")

(map titleize #{"Elbows" "Soap Crving"})
; => ("Elbows for the Brave and True" "Soap Crving for the Brave and True")

(map #(titleize (second %)) {:uncomfortable-thing "Winking"})
; => ("Winking for the Brave and True")
