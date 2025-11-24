(ns matrix
  (:require [clojure.string :as str])
  (:import [java.lang Integer]))

(defn get-mat
  [s]
  (let [rows (str/split s #"\n")
        mat (vec (map #(vec (map Integer/parseInt
                                 (str/split % #" ")))
                      rows))]
    mat))


(defn get-row
  "Returns the i-th row of the matrix s"
  [s i]
  (let [mat (get-mat s)
        row (if (and (>= i 1)
                     (<= i (count mat)))
              (nth mat (dec i))
              [])]
    row))


(defn get-column
  "Returns the i-th column of the matrix s"
  [s i]
  (let [mat (get-mat s)
        col (cond (<= (count mat) 0)
                  []

                  (and (> i 0)
                       (<= i (count (mat 0))))
                  (vec (map #(% (dec i)) mat))

                  :else [])]
    col))
