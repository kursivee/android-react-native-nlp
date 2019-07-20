# android-react-native-nlp
Android POC project using react-native as a bridge to access node-nlp. Using node-nlp created by doc.ai since they have a version that has changes to support RN. https://github.com/doc-ai/nlp.js

### What it does
Starts a basic activity. Clicking the FAB sends an event to RN layer. RN layer runs nlp and sends event back to Android layer.

### Changing the JS
For whatever reason I can't get the metro server to work so I always have to bundle the JS 
`react-native bundle --platform android --dev false --entry-file index.js --bundle-output android/app/src/main/assets/index.android.bundle --assets-dest android/app/src/main/res/ `

### Creating a native module
- Used for Event Bus impl to allow communication between RN and Android
- https://facebook.github.io/react-native/docs/native-modules-android
