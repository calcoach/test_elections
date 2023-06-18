import pandas as pd

# Ruta al archivo XLS
archivo_xls = "/content/counties.xlsx"

# Leer el archivo XLS
dataframe = pd.read_excel(archivo_xls)

# Mostrar el contenido del DataFrame
dataframe

import re

def limpiar_columna(valor):
    valor = valor.strip()  # Eliminar espacios al inicio y al final
    valor = re.sub(r"[^\w\s]+|_$","",valor) # Elimina el los valores que no sean alfanumericos incluyendo el guion
    return valor

dataframe['county'] = dataframe['county'].apply(limpiar_columna)
dataframe



# Convertir el DataFrame a formato JSON
json_data = dataframe.to_json(orient='records')

# Definir la URL de la API
url = 'https://api.example.com/api/countydata'

# Enviar la solicitud POST con el DataFrame como carga útil (payload)
response = requests.post(url, json=json_data)

# Verificar el código de estado de la respuesta
if response.status_code == 200:
    print("El DataFrame se envió correctamente a la API.")
else:
    print("Error al enviar el DataFrame a la API.")