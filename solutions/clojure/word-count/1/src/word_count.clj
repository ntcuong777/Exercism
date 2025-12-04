(ns word-count)

(defn process-word [s]
  (clojure.string/trim (clojure.string/replace s #"^'+|'+$" "")))

(defn take-word [m]
  (if (.find m)
    (let [word (process-word (.group m))]
      (if (> (count word) 0)
        (conj (take-word m) word)
        (take-word m)))
    []))

(defn word-count
  "Counts how many times each word occurs in the given string."
  [s]
  (let [word-re #"[\w']+"
        word-matcher (.matcher word-re s)
        words (lazy-seq (take-word word-matcher))
        word-groups (group-by (fn [x] (clojure.string/lower-case x)) words)
        word-count (into {} (map (fn [[k v]] [k (count v)]) word-groups))]
    word-count)
  )
