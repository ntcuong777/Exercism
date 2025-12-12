(ns bank-account)

(defn open-account [] ;; <- arglist goes here
  (atom {:balance 0 :open? true})
  )

(defn close-account [acc] ;; <- arglist goes here
  (swap! acc assoc :open? false)
  )

(defn get-balance [acc] ;; <- arglist goes here
  (if (@acc :open?)
    (:balance @acc)
    nil)
  )

(defn update-balance [acc money] ;; <- arglist goes here
  (if (@acc :open?)
    (swap! acc (fn [cur-acc]
                 (let [cur-bal (cur-acc :balance)]
                   (assoc cur-acc :balance (+ cur-bal money)))))
    acc)
  )
