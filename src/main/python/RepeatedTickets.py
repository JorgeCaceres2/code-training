from collections import defaultdict

def encontrar_claves_repetidas(data):
    contador_claves = defaultdict(int)

    for ticket in data['tickets']:
        clave = ticket.get('key')
        contador_claves[clave] += 1

    claves_repetidas = {k: v for k, v in contador_claves.items() if v > 1}

    return claves_repetidas

# El JSON proporcionado
input_json = {
    "startAt": 0,
    "maxResults": 50,
    "total": 27,
    "tickets": [
        # ... (todos los objetos de tickets)
    ]
}

# Utilizando la función con los datos de tickets del JSON proporcionado
resultados = encontrar_claves_repetidas(input_json)

print("Claves repetidas y la cantidad de veces que se repiten:")
for clave, cantidad in resultados.items():
    print(f"Clave '{clave}' repetida {cantidad} veces")