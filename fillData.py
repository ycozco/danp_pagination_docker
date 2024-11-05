import csv
import requests

# URL de la API donde quieres cargar los datos
api_url = "https://legendary-orbit-vwvw5jxp7qrhppvx-8443.app.github.dev/api/paintings"

# Leer el archivo CSV y cargar cada fila como JSON
with open('Paintings.csv', newline='', encoding='utf-8') as csvfile:
    reader = csv.DictReader(csvfile)
    for row in reader:
        try:
            # Manejar el año de la pintura (si tiene múltiples años, tomar el primero)
            year_of_painting = row["Year of Painting"]
            if ',' in year_of_painting:
                year_of_painting = year_of_painting.split(',')[0].strip()

            # Verificar y asignar "null" (None en Python) cuando sea necesario
            def parse_int(value):
                return int(value.replace("$", "").replace(",", "")) if value and value != "0" else None

            def parse_str(value):
                return value if value else None

            # Preparar el payload JSON
            payload = {
                "painting": parse_str(row["Painting"]),
                "artist": parse_str(row["Artist"]),
                "yearOfPainting": int(year_of_painting) if year_of_painting and year_of_painting != "0" else None,
                "adjustedPrice": parse_int(row["Adjusted Price"]),
                "originalPrice": parse_int(row["Original Price"]),
                "dateOfSale": parse_str(row["Date of Sale"]),
                "yearOfSale": int(row["Year of Sale"]) if row["Year of Sale"] and row["Year of Sale"] != "0" else None,
                "seller": parse_str(row["Seller"]),
                "buyer": parse_str(row["Buyer"]),
                "auctionHouse": parse_str(row["Auction House"]),
                "image": parse_str(row["Image"]),
                "paintingWikipediaProfile": parse_str(row["Painting Wikipedia Profile"]),
                "artistWikipediaProfile": parse_str(row["Artist Wikipedia Profile"]),
                "description": parse_str(row["Description"])
            }
            
            # Realizar la solicitud POST
            response = requests.post(api_url, json=payload)
            
            # Verificar si se cargó correctamente
            if response.status_code == 201:
                print(f"Successfully added {row['Painting']}")
            else:
                print(f"Failed to add {row['Painting']}: {response.status_code} - {response.text}")
        
        except ValueError as e:
            print(f"Error processing {row['Painting']}: {e}")
