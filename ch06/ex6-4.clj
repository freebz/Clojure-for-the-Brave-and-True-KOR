;; refer

(in-ns 'cheese.taxonomy)
(def cheddars ["mild" "medium" "strong" "sharp" "extra sharp"])
(def bries ["Wisconsin" "Somerset" "Brie de Meaux" "Brie de Melun"])
(in-ns 'cheese.analysis)
(clojure.core/refer 'cheese.taxonomy)
bries
; => ["Wisconsin" "Somerset" "Brie de Meaux" "Brie de Melun"]

cheddars
; => ["mild" "medium" "strong" "sharp" "extra sharp"]


(clojure.core/get (clojure.core/ns-map clojure.core/*ns*) 'bries)
; => #'cheese.taxonomy/bries

(clojure.core/get (clojure.core/ns-map clojure.core/*ns*) 'cheddars)
; => #'cheese.taxonomy/cheddars


(clojure.core/refer 'cheese.taxonomy :only ['bries])
bries
; => ["Wisconsin" "Somerset" "Brie de Meaux" "Brie de Melun"]
cheddars
; => RuntimeException: Unable to resolve symbol: cheddars


(clojure.core/refer 'cheese.taxonomy :exclude ['bries])
bries
; => RuntimeException: Unable to resolve symbol: bries
cheddars
; => ["mild" "medium" "strong" "sharp" "extra sharp"]


(clojure.core/refer 'cheese.taxonomy :rename {'bries 'yummy-bries})
bries
; => RuntimeException: Unable to resolve symbol: bries
yummy-bries
; => ["Wisconsin" "Somerset" "Brie de Meaux" "Brie de Melun"]


(in-ns 'cheese.analysis)
;; "defn" 다음에 대시(-)에 유의할 것.
(defn- private-function
  "Just an example function that does nothing"
  [])


(in-ns 'cheese.taxonomy)
(clojure.core/refer-clojure)
(cheese.analysis/private-funceion)
(refer 'cheese.analysis :only ['private-function])
