(ns pangram)

(defn pangram?
  "Returns true if the given string is a pangram;
  otherwise, it returns false."
  [s]
  (letfn [(is-alphabet [c]
                       (or (<= (int \a) (int c) (int \z))
                           (<= (int \A) (int c) (int \Z))))]
    (->> s
      (filter is-alphabet)
      (map #(Character/toLowerCase %))
      (set)
      (count)
      (= 26)))
  )
