(ns anagram)

(defn anagrams-for
  "Returns all words from candidates that are anagrams of the given word."
  [word candidates]
  (let [w (clojure.string/lower-case word)
        w-sorted (sort w)
        to-low #(clojure.string/lower-case %)]
    (filter (fn [c]
              (and (not (= (to-low c) w))
                   (= (sort (to-low c)) w-sorted)))
            candidates))
)
