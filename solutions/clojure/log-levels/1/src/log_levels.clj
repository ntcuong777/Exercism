(ns log-levels
  (:require [clojure.string :as str]))

(defn message
  "Takes a string representing a log line
   and returns its message with whitespace trimmed."
  [s]
  (let [prefixes-re #"(?:\[ERROR\]|\[INFO\]|\[WARNING\])\s*\:"]
    (str/trim (last (str/split s prefixes-re 2)))))

(defn log-level
  "Takes a string representing a log line
   and returns its level in lower-case."
  [s]
  (let [trimmed-s (str/trim s)]
    (cond (str/starts-with? trimmed-s "[ERROR]") "error"
          (str/starts-with? trimmed-s "[WARNING]") "warning"
          (str/starts-with? trimmed-s "[INFO]") "info")))

(defn reformat
  "Takes a string representing a log line and formats it
   with the message first and the log level in parentheses."
  [s]
  (str (message s) " (" (log-level s) ")"))
