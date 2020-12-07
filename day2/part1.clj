(def input (-> "input.txt" slurp (clojure.string/split #"\n")))

(defn- occurences 
  [character line]
  (->> line
       (map str)
       (filter #(= character %))
       count))

(defn- valid? [line]
  (let [[_ min max letter password] (re-matches #"^(\d+)-(\d+) (.): (.+)$" line)
        min (Integer. min)
        max (Integer. max)
        occurences (occurences letter password)] 
    ; (println min max letter password occurences)
    (<= min occurences max)))

(defn solve [input]
  (->> input
       (filter valid?)
       count))

(comment (solve input))
