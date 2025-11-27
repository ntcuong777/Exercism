(ns strain)

(defn retain
  "Keeps the items in coll for which (pred item) returns true."
  [pred coll]
  (reduce (fn [acc [v pred-ok?]]
            (if pred-ok? (conj acc v) acc))
          []
          (map (fn [v] [v (pred v)]) coll))
  )

(defn discard
  "Removes the items in coll for which (pred item) returns true."
  [pred coll]
  (reduce (fn [acc [v pred-ok?]]
            (if pred-ok? acc (conj acc v)))
          []
          (map (fn [v] [v (pred v)]) coll))
  )
