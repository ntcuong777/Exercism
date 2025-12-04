(ns complex-numbers)

(defn real [[a b]] ;; <- arglist goes here
  a
)

(defn imaginary [[a b]] ;; <- arglist goes here
  b
)

(defn abs [[a b]] ;; <- arglist goes here
  (clojure.math/sqrt (+ (* a a) (* b b)))
)

(defn conjugate [[a b]] ;; <- arglist goes here
  [a (- b)]
)

(defn square-abs [[a b]]
  (+ (* a a) (* b b)))

(defn add [[a b] [c d]] ;; <- arglist goes here
  [(+ a c) (+ b d)]
)

(defn sub [[a b] [c d]] ;; <- arglist goes here
  [(- a c) (- b d)]
)

(defn mul [[a b] [c d]] ;; <- arglist goes here
  [(- (* a c) (* b d)) (+ (* b c) (* a d))]
)

(defn div [[a b] [c d]] ;; <- arglist goes here
  [(/ (+ (* a c) (* b d))
      (square-abs [c d]))
   (/ (- (* b c) (* a d))
      (square-abs [c d]))]
)
