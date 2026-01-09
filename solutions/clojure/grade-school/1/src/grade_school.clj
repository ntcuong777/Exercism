(ns grade-school)

(defn grade [school grade]  ;; <- arglist goes here
    (or (school grade) [])
)

(defn add [school name grade]  ;; <- arglist goes here
    (if (some #(= name %) (school grade))
      (throw (IllegalArgumentException. "invalid"))
      (if (nil? (school grade))
        (assoc school grade [name])
        (assoc school grade (conj (school grade) name)))
      )
)

(defn sorted [school]  ;; <- arglist goes here
    (apply sorted-map
           (mapcat (fn [[k v]]
                     [k (sort v)]) school))
)
