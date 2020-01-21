;; 샤이어의 차선 모형

(def asym-hobbit-body-parts [{:name "head" :size 3}
                             {:name "left-eye" :size 1}
                             {:name "left-ear" :size 1}
                             {:name "mouth" :size 1}
                             {:name "nose" :size 1}
                             {:name "neck" :size 2}
                             {:name "left-shoulder" :size 3}
                             {:name "left-upper-arm" :size 3}
                             {:name "chest" :size 10}
                             {:name "back" :size 10}
                             {:name "left-forearm" :size 3}
                             {:name "abdomen" :size 6}
                             {:name "left-kidney" :size 1}
                             {:name "left-hand" :size 2}
                             {:name "left-knee" :size 2}
                             {:name "left-thigh" :size 4}
                             {:name "left-lower-leg" :size 3}
                             {:name "left-achilles" :size 1}
                             {:name "left-foot" :size 2}])


(defn matching-part
  [part]
  {:name (clojure.string/replace (:name part) #"^left-" "right-")
   :size (:size part)})

(defn symmetrize-body-parts
  ":이름과 :크기를 갖는 일련의 맵이 기대됨."
  [asym-body-parts]
  (loop [remaining-asym-parts asym-body-parts
         final-body-parts []]
    (if (empty? remaining-asym-parts)
      final-body-parts
      (let [[part & remaining] remaining-asym-parts]
        (recur remaining
               (into final-body-parts
                     (set [part (matching-part part)])))))))


(symmetrize-body-parts asym-hobbit-body-parts)
; => [{:name "head", :size 3}
;     {:name "left-eye", :size 1}
;     {:name "right-eye", :size 1}
;     {:name "left-ear", :size 1}
;     {:name "right-ear", :size 1}
;     {:name "mouth", :size 1}
;     {:name "nose", :size 1}
;     {:name "neck", :size 2}
;     {:name "left-shoulder", :size 3}
;     {:name "right-shoulder", :size 3}
;     {:name "left-upper-arm", :size 3}
;     {:name "right-upper-arm", :size 3}
;     {:name "chest", :size 10}
;     {:name "back", :size 10}
;     {:name "left-forearm", :size 3}
;     {:name "right-forearm", :size 3}
;     {:name "abdomen", :size 6}
;     {:name "left-kidney", :size 1}
;     {:name "right-kidney", :size 1}
;     {:name "left-hand", :size 2}
;     {:name "right-hand", :size 2}
;     {:name "left-knee", :size 2}
;     {:name "right-knee", :size 2}
;     {:name "left-thigh", :size 4}
;     {:name "right-thigh", :size 4}
;     {:name "left-lower-leg", :size 3}
;     {:name "right-lower-leg", :size 3}
;     {:name "left-achilles", :size 1}
;     {:name "right-achilles", :size 1}
;     {:name "left-foot", :size 2}
;     {:name "right-foot", :size 2}]
