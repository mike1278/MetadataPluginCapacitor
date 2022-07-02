import { WebPlugin } from '@capacitor/core';

import type { MetadataPlugin } from './definitions';

export class MetadataWeb extends WebPlugin implements MetadataPlugin {
  async metadata(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
