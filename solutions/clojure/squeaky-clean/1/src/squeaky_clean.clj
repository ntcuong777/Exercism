(ns squeaky-clean
  (:require [clojure.string :as str]))

(defn replace-spaces
  [s]
  (str/replace s #" " "_"))

(defn replace-ctrl
  [s]
  (str/join (map (fn [c]
                   (if (Character/isISOControl c)
                     "CTRL"
                     c))
                 s)))

(defn kebab-to-camel
  [s]
  (str/replace s #"\-."
               (fn [[_ c]]
                 (str/upper-case c))))

(defn omit-non-chars
  [s]
  (str/join (filter (fn [c]
                      (Character/isLetter c))
                    s)))

(defn omit-greek-lowercase
  [s]
  (str/join (filter (fn [c]
                      (not (<= (int \u03B1)
                               (int c)
                               (int \u03C9))))
                    s)))

(defn clean
  "TODO: add docstring"
  [s]
  (-> s
      replace-spaces
      replace-ctrl
      kebab-to-camel
      omit-non-chars
      omit-greek-lowercase))
