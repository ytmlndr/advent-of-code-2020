(def input ["1-3 a: abcde" "1-3 b: cdefg" "2-9 c: ccccccccc"])

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
