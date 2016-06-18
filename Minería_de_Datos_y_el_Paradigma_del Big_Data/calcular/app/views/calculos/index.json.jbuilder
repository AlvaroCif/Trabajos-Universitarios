json.array!(@calculos) do |calculo|
  json.extract! calculo, :id, :op1, :op2, :operando, :t0, :t1
  json.url calculo_url(calculo, format: :json)
end
