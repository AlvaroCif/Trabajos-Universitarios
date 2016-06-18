# -*- coding: utf-8 -*-
"""
Editor de Spyder

Este es un archivo temporal
"""

import pandas as pd
from sklearn import preprocessing
from sklearn.cross_validation import train_test_split
from sklearn.linear_model import LinearRegression
from sklearn import metrics
import numpy as np
from sklearn import cross_validation
from sklearn.externals import joblib
from sklearn.ensemble import RandomForestRegressor

le = preprocessing.LabelEncoder()

data = pd.read_csv("datos.csv", index_col=0)
print data.head()
print data.tail()
print data.shape
#print data.loc[data.tiempo<0]

def convertir(datos):
    datos.op = le.fit_transform(datos.op)
    datos.nombre = le.fit_transform(datos.nombre)
    return datos

data_conv = convertir(data)
  
def mayorque(x,y):
    if (x>=y):
        return 0
    else:
        return 1
        
data_conv["mayorque"]= data_conv.apply(lambda row:mayorque(row["op1"],row["op2"]),axis=1)
data_conv = data_conv.loc[data_conv.tiempo < 120]       
data_conv = data_conv.loc[data_conv.tiempo > 1]
feature_cols = ['op1', 'op', 'op2', 'mayorque']
X = data_conv[feature_cols]

'''# print the first 5 rows
print X.head()
# check the type and shape of X
print type(X)
print X.shape'''

y = data_conv['tiempo']

'''# print the first 5 values
print y.head()
# check the type and shape of y
print type(y)
print y.shape'''


X_train, X_test, y_train, y_test = train_test_split(X, y, random_state=1)

'''# default split is 75% for training and 25% for testing
print X_train.shape
print y_train.shape
print X_test.shape
print y_test.shape
'''

regr = RandomForestRegressor(n_estimators=100,max_depth = 4.5)

'''# instantiate
linreg = LinearRegression()'''
# fit the model to the training data (learn the coefficients)
regr.fit(X_train, y_train)
'''# print the intercept
print linreg.intercept_
# pair the feature names with the coefficients
print zip(feature_cols, linreg.coef_)'''
# make predictions on the testing set
y_pred = regr.predict(X_test)
#print np.sqrt(metrics.mean_absolute_error(y_test, y_pred))
#con todas las features
# y = -1077709.58 + 106807.87*nombre - 7794.82*op1 + 129247.95*op + 7612.25*op2
#rmse=585784.995789 

#sin nombre
# y = -594262.09 - 7079.81*op1 + 131927.11*op + 8550.11*op2
#rmse=461066.137527

'''scores = cross_validation.cross_val_score(regr, X_train, y_train, cv=10, scoring='mean_absolute_error')
print scores.mean()'''
print np.sqrt(-cross_validation.cross_val_score(regr, X_train, y_train, cv=10, scoring='mean_absolute_error')).mean()


joblib.dump(regr, 'filename.pkl')
