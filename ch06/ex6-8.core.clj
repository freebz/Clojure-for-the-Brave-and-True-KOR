(ns the-divine-cheese-code.core)
;; Ensure that the SVG code is evaluated
(require 'the-divine-cheese-code.visualization.svg)
;; Refer the namespace so that you don't have to use the
;; fully qualified name to reference svg functions
(refer 'the-divine-cheese-code.visualization.svg)

(def heists [{:location "Cologne, Germany"
              :cheese-name "Archbishop Hildebold's Cheese Pretzel"
              :lat 50.95
              :lng 6.97}
             {:location "Zurich, Switzerland"
              :cheese-name "The Standard Emmental"
              :lat 47.37
              :lng 8.55}
             {:location "Marseille, France"
              :cheese-name "Le Fromage de Cosquer"
              :lat 43.30
              :lng 5.37}
             {:location "Zurich, Switzerland"
              :cheese-name "The Lesser Emmental"
              :lat 47.37
              :lng 8.55}
             {:location "Vatican City"
              :cheese-name "The Cheese of Turin"
              :lat 41.90
              :lng 12.45}])

(defn -main
  [& args]
  (println (points heists)))


; => 50.95,6.97 47.37,8.55 43.3,5.37 47.37,8.55 41.9,12.45


(require '[the-divine-cheese-code.visualization.svg :as svg])


(require 'the-divine-cheese-code.visualization.svg)
(alias 'svg 'the-divine-cheese-code.visualization.svg)


(svg/pointsheists)
; => "50.95,6.97 47.37,8.55 43.3,5.37 47.37,8.55 41.9,12.45"


(require 'the-divine-cheese-code.visualization.svg)
(refer 'the-divine-cheese-code.visualization.svg)


(use 'the-divine-cheese-code.visualization.svg)


(require 'the-divine-cheese-code.visualization.svg)
(refer 'the-divine-cheese-code.visualization.svg)
(alias 'svg 'the-divine-cheese-code.visualization.svg)


(use '[the-divine-cheese-code.visualization.svg :as svg])
(= svg/points points)
; => true

(= svg/latlng->point latlng->point)
;= true


(require 'the-divine-cheese-code.visualization.svg)
(refer 'the-divine-cheese-code.visualization.svg :as :only ['points])


(use '[the-divine-cheese-code.visualization.svg :as svg :only [points]])
(refer 'the-divine-cheese-code.visualization.svg :as :only ['points])
(= svg/points points)
; => true

;; We can use the alias to reach latlng->point
svg/latlng->point
; This doesn't throw an exception

;; But we can't use the bare name
latlng->point
; This does throw an exception!
