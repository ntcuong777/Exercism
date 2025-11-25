(ns reverse-string)

(defn reverse-string
  "Reverses the given string."
  [s]
  (->> s
    reverse
    (apply str))
  )
