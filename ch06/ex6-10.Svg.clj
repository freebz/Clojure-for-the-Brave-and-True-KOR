;; 도둑을 잡으려면

(ns the-divine-cheese-code.visualization.svg
  (:require [clojure.string :as s])
  (:refer-clojure :execlude [min max]))

(defn comparator-over-maps
  [comparison-fn ks]
  (fn [maps]
    (zipmap ks
            (map (fn [k] (apply comparison-fn (map k maps)))
                 ks))))

(def min (comparator-over-maps clojure.core/min [:lat :lng]))
(def max (comparator-over-maps clojure.core/max [:lat :lng]))


(min [{:a 1 :b 3} {:a 5 :b 0}])
; => {:a 1, :b 0}


(zipmap [:a :b] [1 2])
; => {:a 1 :b 2}


(defn translate-to-00
     [locations]
     (let [mincoords (min locations)]
       (map #(merge-with - % mincoords) locations)))

(defn scale
     [width height locations]
     (let [maxcoords (max locations)
           ratio {:lat (/ height (:lat maxcoords))
                  :lng (/ width (:lng maxcoords))}]
       (map #(merge-with * % ratio) locations)))


(merge-with - {:lat 50 :lng 10} {:lat 5 :lng 5})
; => {:lat 45, :lng 5}
