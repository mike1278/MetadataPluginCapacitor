import { registerPlugin } from '@capacitor/core';

import type { MetadataPlugin } from './definitions';

const Metadata = registerPlugin<MetadataPlugin>('Metadata', {
  web: () => import('./web').then(m => new m.MetadataWeb()),
});

export * from './definitions';
export { Metadata };
