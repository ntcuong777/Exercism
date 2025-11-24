defmodule BirdCount do
  def today(list) do
    List.first(list)
  end

  def increment_day_count([]), do: [1]
  def increment_day_count([head | tail]) do
    [head + 1 | tail]
  end

  def has_day_without_birds?(list) do
    Enum.any?(list, fn x -> x == 0 end)
  end

  def total(list) do
    Enum.sum(list)
  end

  def busy_days(list) do
    list
    |> Enum.map(fn x -> if x >= 5, do: 1, else: 0 end)
    |> Enum.sum
  end
end
