require 'test_helper'

class CalculosControllerTest < ActionController::TestCase
  setup do
    @calculo = calculos(:one)
  end

  test "should get index" do
    get :index
    assert_response :success
    assert_not_nil assigns(:calculos)
  end

  test "should get new" do
    get :new
    assert_response :success
  end

  test "should create calculo" do
    assert_difference('Calculo.count') do
      post :create, calculo: { op1: @calculo.op1, op2: @calculo.op2, operando: @calculo.operando, t0: @calculo.t0, t1: @calculo.t1 }
    end

    assert_redirected_to calculo_path(assigns(:calculo))
  end

  test "should show calculo" do
    get :show, id: @calculo
    assert_response :success
  end

  test "should get edit" do
    get :edit, id: @calculo
    assert_response :success
  end

  test "should update calculo" do
    patch :update, id: @calculo, calculo: { op1: @calculo.op1, op2: @calculo.op2, operando: @calculo.operando, t0: @calculo.t0, t1: @calculo.t1 }
    assert_redirected_to calculo_path(assigns(:calculo))
  end

  test "should destroy calculo" do
    assert_difference('Calculo.count', -1) do
      delete :destroy, id: @calculo
    end

    assert_redirected_to calculos_path
  end
end
