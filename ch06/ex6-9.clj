;; ns 매크로

(ns the-divine-cheese-code.core
  (:refer-clojure :exclude [println]))


(in-ns 'the-divine-cheese-code.core)
(refer 'clojure.core :exclude ['println])


(ns the-divine-cheese-code.core
  (:require 'the-divine-cheese-code.core.visualization.svg))


(in-ns 'the-divine-cheese-code.core)
(require 'the-divine-cheese-code.core.visualization.svg)


(ns the-divine-cheese-code.core
  (:require [the-divine-cheese-code.core.visualization.svg :as svg]))


(in-ns 'the-divine-cheese-code.core)
(require ['the-divine-cheese-code.core.visualization.svg :as 'svg])


(ns the-divine-cheese-code.core
  (:require [the-divine-cheese-code.core.visualization.svg :as svg]
            [clojure.java.browse :as browse]))


(in-ns 'the-divine-cheese-code.core)
(require ['the-divine-cheese-code.core.visualization.svg :as svg])
(require ['clojure.java.browse :as 'browse])


(ns the-divine-cheese-code.core
  (:require [the-divine-cheese-code.core.visualization.svg :refer [points]]))


(in-ns 'the-divine-cheese-code.core)
(require 'the-divine-cheese-code.core.visualization.svg)
(refer 'the-divine-cheese-code.core.visualization.svg :only ['points])


(ns the-divine-cheese-code.core
  (:require [the-divine-cheese-code.core.visualization.svg :refer :all]))


(in-ns 'the-divine-cheese-code.core)
(require 'the-divine-cheese-code.core.visualization.svg)
(refer 'the-divine-cheese-code.core.visualization.svg)


(ns the-divine-cheese-code.core
  (:use clojure.java.browse))


(in-ns 'the-divine-cheese-code.core)
(use 'clojure.java.browse)


(ns the-divine-cheese-code.core
  (:use [clojure.java.browse io]))


(in-ns 'the-divine-cheese-code.core)
(use 'clojure.java.browse)
(use 'clojure.java.io)
