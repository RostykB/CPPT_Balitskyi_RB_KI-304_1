# Створюємо папку doc, якщо її нема
$docPath = "$PSScriptRoot\doc"
if (-not (Test-Path $docPath)) {
    New-Item -ItemType Directory -Path $docPath | Out-Null
}

# Збираємо всі .java файли у поточній папці
$javas = Get-ChildItem -Filter *.java | ForEach-Object { $_.FullName }

# Генеруємо Javadoc
javadoc -d $docPath $javas

# Відкриваємо index.html у браузері
Start-Process "$docPath\index.html"