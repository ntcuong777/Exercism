defmodule LanguageList do
  def new() do
    []
  end

  def add(list, language) do
    [language | list]
  end

  def remove([head | tail]) do
    tail
  end

  def first([head | _tail]) do
    head
  end

  def count(list) do
    Enum.count(list)
  end

  def functional_list?(list) do
    Enum.any?(list, &(&1 == "Elixir"))
  end
end
