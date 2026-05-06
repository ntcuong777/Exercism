type dna = [ `A | `C | `G | `T ]
type rna = [ `A | `C | `G | `U ]

let to_rna dna =
  let rec to_rna' acc xs =
  match xs with
  | [] -> List.rev acc
  | `A :: xs -> to_rna' (`U :: acc) xs
  | `C :: xs -> to_rna' (`G :: acc) xs
  | `G :: xs -> to_rna' (`C :: acc) xs
  | `T :: xs -> to_rna' (`A :: acc) xs
  in to_rna' [] dna
