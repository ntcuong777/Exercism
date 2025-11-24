type nucleotide = A | C | G | T

let hamming_distance s1 s2 =
  if List.length s1 <> List.length s2 then
    Error "strands must be of equal length"
  else
    let rec aux i count = 
      if i >= List.length s1 then Ok count
      else
        let count' = if List.nth s1 i <> List.nth s2 i then count + 1 else count
        in aux (i + 1) count'
    in
    aux 0 0
